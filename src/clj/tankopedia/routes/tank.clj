(ns tankopedia.routes.tank
  (:require [tankopedia.layout :as layout]
            [compojure.core :refer [defroutes GET POST]]
            [tankopedia.controllers.tank_controller :as tankController]
            ))


(defroutes tank-routes
           (GET "/tanks" [:as request] (tankController/get-tanks request))
           (GET "/tank/:id" [id :as request] (tankController/get-tank-by-id request id)))