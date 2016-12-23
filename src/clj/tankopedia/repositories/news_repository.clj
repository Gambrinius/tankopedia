(ns tankopedia.repositories.news_repository
  (:require [compojure.core :refer :all]
            [clojure.java.jdbc :as jdbc]
            [tankopedia.db.core :as db]
            [tankopedia.models.model :as model]
            [tankopedia.repositories.base_repository :as baseRepository]))

(defrecord NewsRepositoryImpl [db-spec]
  baseRepository/BaseRepository

  (find-by-id [this id]
    (let [news-item (first (jdbc/query db-spec ["SELECT * FROM news WHERE n_id = ?" id]))]
      (model/->News (news-item :n_id) (news-item :n_title) (news-item :n_short) (news-item :n_text) (news-item :n_creation) (news-item :n_user_id))))

  (find-all [this]
    (let [news-list (jdbc/query db-spec ["SELECT * FROM news ORDER BY n_creation DESC"])]
      (for [news-item news-list]
        (model/->News (news-item :n_id) (news-item :n_title) (news-item :n_short) (news-item :n_text) (news-item :n_creation) (news-item :n_user_id)))))

  (add [this model]
    (jdbc/insert! db-spec :news model))

  (delete [this id] (jdbc/delete! db-spec :news ["n_id = ?" id])))

(def newsRepositoryComponent (->NewsRepositoryImpl db/db-spec))

