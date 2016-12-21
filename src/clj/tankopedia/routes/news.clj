(ns tankopedia.routes.news
  (:require [tankopedia.controllers.news_controller :as newsController]
            [compojure.core :refer [defroutes GET POST]]))


(defroutes news-routes
           (GET "/news" [:as request] (newsController/get-news request))
           (GET "/add_news" [:as request] (newsController/add-news-page request nil))
           (POST "/add_news" [:as request] (newsController/add-news request))
           )
