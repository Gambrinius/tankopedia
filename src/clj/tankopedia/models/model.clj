(ns tankopedia.models.model)

(defrecord User [u_id, u_login, u_name, u_password, u_role])

(defrecord Role [r_id, r_role])

(defrecord Tank [tank_id, tank_health, tank_name, tank_weight,  tank_level,
                 tank_premium, tank_price, tank_small_icon, tank_big_icon,
                 tank_category, tank_country])

(defrecord Category [c_id, c_name, c_icon])

(defrecord Country [c_id, c_name, c_flag])

(defrecord News [n_id, n_title, n_short, n_text, n_creation, n_user_id])

(defrecord Comment [c_id, c_user_id, c_news_id, c_text, c_creation, c_user_name])