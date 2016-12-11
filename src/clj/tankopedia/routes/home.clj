(ns tankopedia.routes.home
  (:require [tankopedia.layout :as layout]
            [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]
            [tankopedia.db.core :as db]))

(defn home-page []
  (layout/render
    "home.html" {:docs (-> "docs/docs.md" io/resource slurp)}))

(defn about-page []
  (layout/render "about.html"))

(defn get-tanks []
  (layout/render
    "tanks.html" {:tanks (db/get-tanks)}))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/about" [] (about-page))
  (GET "/tanks" [] (get-tanks)))
