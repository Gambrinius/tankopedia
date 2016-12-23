(ns tankopedia.repositories.cache_repository
  (:require [tankopedia.models.model :as model]
            [clojure.java.jdbc :as jdbc]
            [tankopedia.db.core :as db]))

(def cache (atom {}))

(defprotocol CacheRepository
  (update-cache[this])
  (get-items-cache [this]))


(defrecord CacheRepositoryImpl [db-spec]
    CacheRepository

  (update-cache [this]
      (let [news-list (jdbc/query db-spec ["SELECT TOP 10 * FROM news ORDER BY n_creation DESC"])]
        (for [news-item news-list]
          (model/->News (news-item :n_id) (news-item :n_title) (news-item :n_short)
                        (news-item :n_text) (news-item :n_creation) (news-item :n_user_id)) )
        (reset! cache news-list)))

  (get-items-cache [this]
    (if (empty? @cache)
      (update-cache this)
      @cache))
  )

(def cacheRepositoryComponent (->CacheRepositoryImpl db/db-spec))
