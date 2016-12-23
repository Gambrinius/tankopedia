(ns tankopedia.repositories.comment_repository
  (:require [compojure.core :refer :all]
            [clojure.java.jdbc :as jdbc]
            [tankopedia.db.core :as db]
            [tankopedia.models.model :as model]
            [tankopedia.repositories.base_repository :as baseRepository]))

(defprotocol CommentRepository
  (find-by-news-id [this id]))


(defrecord CommentRepositoryImpl [db-spec]
  baseRepository/BaseRepository

  (find-by-id [this id]
    (let [comment-item (first (jdbc/query db-spec ["SELECT * FROM dbo.[comments] WHERE c_id = ?" id]))]
      (model/->Comment (comment-item :c_id) (comment-item :c_user_id) (comment-item :c_news_id)
                    (comment-item :c_text) (comment-item :c_creation) (comment-item :c_user_name))))

  (find-all [this]
    (let [comments-list (jdbc/query db-spec ["SELECT * FROM dbo.[comments] ORDER BY c_creation DESC"])]
      (for [comment-item comments-list]
        (model/->Comment (comment-item :c_id) (comment-item :c_user_id) (comment-item :c_news_id)
                         (comment-item :c_text) (comment-item :c_creation) (comment-item :c_user_name)))))

  (add [this model]
    (jdbc/insert! db-spec "dbo.[comments]" model))

  (delete [this id] (jdbc/delete! db-spec "dbo.[comments]" ["c_id = ?" id]))

  CommentRepository

  (find-by-news-id [this news-id]
    (let [comments-list (jdbc/query db-spec ["SELECT * FROM dbo.[comments] WHERE c_news_id = ?" news-id])]
      (for [comment-item comments-list]
      (model/->Comment (comment-item :c_id) (comment-item :c_user_id) (comment-item :c_news_id)
                       (comment-item :c_text) (comment-item :c_creation) (comment-item :c_user_name)))))
  )

(def commentRepositoryComponent (->CommentRepositoryImpl db/db-spec))