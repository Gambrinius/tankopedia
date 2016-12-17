(ns tankopedia.repositories.news-repository
  (:require [compojure.core :refer :all]
            [clojure.java.jdbc :as jdbc]
            [tankopedia.db.core :as db]
            [tankopedia.models.model :as model]
            [tankopedia.repositories.base_repository :as baseRepository]))

(defrecord NewsRepositoryImpl [db-spec]
  baseRepository/BaseRepository

  (find-by-id [this id]
    (let [news-item (first (jdbc/query db-spec ["SELECT * FROM news WHERE id = ?" id]))]
      (model/->News (news-item :id) (news-item :title) (news-item :short_text) (news-item :full_text) (news-item :creation_date))))

  (find-all [this]
    (let [news-list (jdbc/query db-spec ["SELECT * FROM news ORDER BY creation_date DESC"])]
      (for [news-item news-list]
        (model/->News (news-item :id) (news-item :title) (news-item :short_text) (news-item :full_text) (news-item :creation_date)))))

  (add [this model]
    (jdbc/insert! db-spec :news model))

  (delete [this id] (jdbc/delete! db-spec :news ["id = ?" id])))

(def newsRepositoryComponent (->NewsRepositoryImpl db/db-spec))