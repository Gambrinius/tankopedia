(ns tankopedia.controllers.news_controller
  (:require [tankopedia.repositories.base_repository :as baseRepository]
            [tankopedia.repositories.news_repository :as newsRepository]
            [tankopedia.repositories.comment_repository :as commentRepository]
            [tankopedia.repositories.cache_repository :as cacheRepository]
            [tankopedia.layout :as layout]
            [tankopedia.utils.validation :as utils]
            [bouncer.core :as b]
            [bouncer.validators :as v]
            [tankopedia.models.model :as model]))

(defn now [] (.toString(java.time.LocalDateTime/now)) )

(defn validate-new-news [news]  (b/validate news
                                            :title v/required
                                            :desc v/required
                                            :text v/required
                                            ))

(defn validate-new-comment [comment] (b/validate comment
                                                 :text v/required))

(defn get-news [request]
  (let [news-list (baseRepository/find-all newsRepository/newsRepositoryComponent)]
    (layout/render
      request "all_news.html" {:news news-list})))

(defn news-page [request id messages]
  (let [news (baseRepository/find-by-id newsRepository/newsRepositoryComponent id)
        comments (commentRepository/find-by-news-id commentRepository/commentRepositoryComponent id)]
    (layout/render
      request "news_page.html" {:item news :comments comments :messages messages })))

(defn create-comment [user_id news_id text user_name]
  (baseRepository/add commentRepository/commentRepositoryComponent
                          {:c_user_id user_id, :c_news_id news_id, :c_text text,
                           :c_creation (now), :c_user_name user_name}))

(defn news-page-comment [request news_id]
  (let [user_id (get-in request [:session :identity] )
        text (get-in request [:form-params "text"])
        user_name (get-in request [:session :name])
        comment {:text text}
        validation-result (first (validate-new-comment comment))]

    (if (nil? validation-result)
      (do
        (create-comment user_id news_id text user_name)
        (news-page request news_id nil)
        )
      (news-page request news_id (utils/fix-validation-messages validation-result))))
  )

(defn get-latest-news [request]
  (let [news-list (cacheRepository/get-items-cache cacheRepository/cacheRepositoryComponent)]
    (layout/render
      request "home.html" {:news news-list})))

(defn add-news-page [request messages]
  (layout/render
    request "add_news.html" {:messages messages}))

(defn create-news [title desc text user_id]
  (baseRepository/add newsRepository/newsRepositoryComponent
                      {:n_title title, :n_short desc, :n_text text, :n_creation (now), :n_user_id user_id})
    (cacheRepository/update-cache cacheRepository/cacheRepositoryComponent))

(defn add-news [request]
  (let [user_id (get-in request [:session :identity] )
        title (get-in request [:form-params "title"])
        desc (get-in request [:form-params "short"])
        text (get-in request [:form-params "text"])
        news {:title title :desc desc :text text}
        validation-result (first (validate-new-news news))]

    (if (nil? validation-result)
      (do
        (create-news title desc text user_id)
        (add-news-page request (utils/fix-validation-messages {:success "((News added successfully))"}))
        )
      (add-news-page request (utils/fix-validation-messages validation-result)))))
