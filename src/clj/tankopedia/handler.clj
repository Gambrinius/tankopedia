(ns tankopedia.handler
  (:require [compojure.core :refer [routes wrap-routes]]
            [tankopedia.layout :refer [error-page]]
            [tankopedia.routes.home :refer [home-routes]]
            [tankopedia.routes.user :refer [user-routes]]
            [tankopedia.routes.news :refer [news-routes]]
            [compojure.route :as route]
            [tankopedia.env :refer [defaults]]
            [mount.core :as mount]
            [tankopedia.middleware :as middleware]))

(mount/defstate init-app
                :start ((or (:init defaults) identity))
                :stop  ((or (:stop defaults) identity)))

(def app-routes
  (routes
    (-> #'home-routes
        (wrap-routes middleware/wrap-formats))
    (-> #'user-routes
        (wrap-routes middleware/wrap-formats))
    (-> #'news-routes                                       ;используется для добавления/изменения новостей
        (wrap-routes middleware/wrap-formats)               ;(возможно только для авториз. польз.)
        ;(wrap-routes middleware/wrap-restricted)
        )
    (route/not-found
      (:body
        (error-page {:status 404
                     :title "page not found"})))))


(defn app [] (middleware/wrap-base #'app-routes))
