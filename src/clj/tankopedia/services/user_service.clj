(ns tankopedia.services.user_service
  (:require
    [tankopedia.services.session_service :as sessionService]
    [tankopedia.repositories.user_repository :as userRepository]
    [tankopedia.repositories.base_repository :as baseRepository]
    ))


(defn register [user]
  (baseRepository/add userRepository/userRepositoryComponent user))

(defn getAuthenticatedUserRole [request]
  (get-in request [:session :role]))

(defn getAuthenticatedUserLogin [request]
  (get-in request [:session :login]))

(defn getAuthenticatedUserEmail [request]
  (get-in request [:session :email]))

(defn isUserLoggedIn? [request]
  (not-empty (getAuthenticatedUserLogin request)))
