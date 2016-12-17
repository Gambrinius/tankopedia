(ns tankopedia.controllers.user_controller
  (:use [bouncer.validators :only [defvalidator]])
  (:require [tankopedia.layout :as layout]
            [bouncer.core :as b]
            [bouncer.validators :as v]
            [buddy.hashers :as hashers]
            [buddy.auth.backends :as backends]))

#_
(defn registration-page [messages request]
  (layout/render request "account/registration.html" {:messages messages}))


#_
(defn validate-new-user [user] (b/validate user
                                           :login [v/required unique-login]
                                           :password v/required
                                           :password2 [[v/required :message "Password confirmation must be present"] [equals (:password user)]]
                                           :email [[v/email :pre (comp not blank? :email)]]
                                           :birth-date [[v/datetime :pre (comp not blank? :birth-date)]]))
#_
(defn validate-singin-user [user] (b/validate user
                                              :login v/required
                                              :password v/required))
#_
(defn create-user [login password] (let [salt (str (rand-int 123456789))
                                         hash-password (hashers/encrypt password {:alg :pbkdf2+sha256 :salt salt})]
                                     (create-item user-repository {:id nil :login login :password hash-password :seed salt})
                                     (:id (get-user-by-login user-repository login))))