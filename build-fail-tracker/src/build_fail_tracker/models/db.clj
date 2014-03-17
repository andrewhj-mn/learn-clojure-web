(ns build-fail-tracker.models.db
  (:use korma.core
        [korma.db]))

(defdb prod (postgres {:db "BUILDTRACK"
                       :user "buildtrack"
                       :password "buildtrack"}))
(defentity user)
(defentity build-failures
  (belongs-to user))

(defn create-user [user]
  (insert user (values user)))

;; (defn get-user [id]
;;   (first (select user
;;                  (where {:id id})
;;                  (limit 1))))

;; (defn delete-user [id]
;;   (delete user (where {:id id})))

(defn all-users []
  (select user))
