(ns tankopedia.routes.user
  (:require [tankopedia.controllers.user_controller :as userController]
            [compojure.core :refer [defroutes GET POST]]))



(defroutes user-routes
           (GET "/users" [] (userController/get-users))
           (GET "/registration" [] (userController/registration-page nil nil))
           (POST "/registration" [& params] (userController/registration-post params))
           (GET "/signin" [] (userController/signin-page nil nil))
           (POST "/signin" [& params] (userController/signin params))
           (POST "/signout" [:as request] (userController/signout request))
           )