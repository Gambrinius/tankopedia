(ns tankopedia.models.model)

(defrecord User [u_id, u_login, u_name, u_password, u_role])

(defrecord Role [r_id, r_role])

(defrecord Tank [tank_id, tank_health, tank_name, tank_weight, tank_category, tank_level, tank_country,
                 tank_premium, tank_price, tank_small_icon, tank_big_icon])

(defrecord Category [c_id, c_name, c_icon])

(defrecord Country [c_id, c_name, c_flag])

(defrecord News [id, title, short_text, full_text, creation_date]) ; надо поменять

(defrecord Comment [id, text, creation_date, news_id, user_id]) ; надо поменять