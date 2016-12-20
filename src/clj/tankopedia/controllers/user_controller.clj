(ns tankopedia.controllers.user_controller
  (:require [tankopedia.repositories.base_repository :as baseRepository]
            [tankopedia.repositories.user_repository :as userRepository]
            [tankopedia.layout :as layout]
            [clojure.string :refer [blank?]]
            [buddy.hashers :as hashers]
            [tankopedia.utils.validation :as utils]
            [tankopedia.models.model :as model]
            [bouncer.validators :as v]
            [bouncer.core :as b]))


(defn get-users []
  (let [users-list (baseRepository/find-all userRepository/userRepositoryComponent)]
    (layout/render
      "users.html" {:users users-list})))

(defn registration-page [messages]
  (layout/render
    "registration.html" {:messages messages}))
()
(v/defvalidator equals  {:default-message-format "passwords are not equal"} [pass pass2] (= (compare pass pass2) 0))


(v/defvalidator unique-login {:default-message-format "user with such login already exist"} [login]
              (nil? (userRepository/find-by-login userRepository/userRepositoryComponent login)))


(defn validate-new-user [user]  (b/validate user
                                           :login [v/required unique-login [v/email :pre (comp not blank? :email)]]
                                           :password v/required
                                           :password2 [[v/required :message "Password confirmation must be present"] [equals (:password user)]]
                                           :name v/required
                                 ))


(defn create-user [login password name] (let [salt (str 123456789)
                                         hash-password (hashers/derive password {:alg :pbkdf2+sha256 :salt salt})]
                                     (baseRepository/add userRepository/userRepositoryComponent
                                                         {:u_login login, :u_name name, :u_password hash-password, :u_role 2})))

(defn registration-post [user]

    (let [validation-result (first (validate-new-user user))]
      (if (nil? validation-result)
        (do
          (create-user (:login user) (:password user) (:name user))
          (registration-page (utils/fix-validation-messages {:success "((registration completed successfully))"}))
          )
        (registration-page (utils/fix-validation-messages validation-result)))))

(defn signin-page [messages]
  (layout/render
    "singin.html" {:messages messages}))

(defn signin [user]
  (let [login (:login user)
        password (:password user)]
      (let [salt (str 123456789)
            user (userRepository/find-by-login userRepository/userRepositoryComponent login)
            hash-pass-db (:u_password user)
            hash-pass (hashers/encrypt password {:alg :pbkdf2+sha256 :salt salt})]
        (if (and hash-pass hash-pass-db (= hash-pass hash-pass-db))
          (layout/render
            "home.html" {:message "Successful Sign in ..."})))))

(defn signout []
  (layout/render
    "home.html" {:message "Not working yet..."}))