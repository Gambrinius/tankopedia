(ns tankopedia.controllers.news_controller
  (:require [tankopedia.repositories.base_repository :as baseRepository]
            [tankopedia.repositories.news_repository :as newsRepository]
            [tankopedia.layout :as layout]
            [tankopedia.utils.validation :as utils]
            [bouncer.core :as b]
            [bouncer.validators :as v]
            [tankopedia.models.model :as model]))

(defn get-news [request]
  (let [news-list (baseRepository/find-all newsRepository/newsRepositoryComponent)]
    (layout/render
      request "home.html" {:news news-list})))

(defn add-news-page [request messages]
  (layout/render
    request "add_news.html" {:messages messages}))


(defn validate-new-news [news]  (b/validate news
                                            :title v/required
                                            :desc v/required
                                            :text v/required
                                           ))


(defn now [] (.toString(java.time.LocalDateTime/now)) )

(defn create-news [title desc text user_id]
  (let [model {:n_title title, :n_short desc, :n_text text, :n_creation (now), :n_user_id user_id}] (println model))
  (baseRepository/add newsRepository/newsRepositoryComponent
                      {:n_title title, :n_short desc, :n_text text, :n_creation (now), :n_user_id user_id}))

(defn add-news [request]
  (let [user_id (get-in request [:session :identity] )
        title (get-in request [:form-params "title"])
        desc (get-in request [:form-params "short"])
        text (get-in request [:form-params "text"])
        news {:title title :desc desc :text text}
        validation-result (first (validate-new-news news))]
    (println user_id)
    (if (nil? validation-result)
      (do
        (create-news title desc text user_id)
        (add-news-page request (utils/fix-validation-messages {:success "((News added successfully))"}))
        )
      (add-news-page request (utils/fix-validation-messages validation-result)))))
