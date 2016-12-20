(ns tankopedia.routes.home
  (:require [tankopedia.layout :as layout]
            [compojure.core :refer [defroutes GET POST]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]
            [tankopedia.db.queries :as db]
            [tankopedia.repositories.base_repository :as baseRepository]
            [tankopedia.repositories.tank_repository :as tankRepository]
            [tankopedia.models.model :as model]
            [tankopedia.controllers.user_controller :as userController]))

(defn home-page [request]
  (if (not= request nil)
    (println (request :session))
    (println nil)
    )
  (layout/render
    request "home.html" {:docs (-> "docs/docs.md" io/resource slurp)}))

(defn about-page [request]
  (layout/render request "about.html"))

(defn get-tank-by-id [id]
  (let [tank-item (baseRepository/find-by-id tankRepository/tankRepositoryComponent id)]
  (layout/render
    "tank.html" {:tank tank-item})))

(defn get-tanks []
  (let [tanks-list (baseRepository/find-all tankRepository/tankRepositoryComponent )]
    (layout/render
      "tanks.html" {:tanks tanks-list})))


(defroutes home-routes
  (GET "/" [:as request] (home-page request))
  (GET "/home" [:as request] (home-page request))
  (GET "/about" [:as request] (about-page request))
  (GET "/tanks" [] (get-tanks))
  (GET "/tank/:id" [id] (get-tank-by-id id))
  (GET "/users" [] (userController/get-users))
  (GET "/registration" [] (userController/registration-page nil nil))
  (POST "/registration" [& params] (userController/registration-post params))
  (GET "/signin" [] (userController/signin-page nil nil))
  (POST "/signin" [& params] (userController/signin params))
  (POST "/signout" [:as request] (userController/signout request))
  )
