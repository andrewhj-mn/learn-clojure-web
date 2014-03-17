(ns build-fail-tracker.routes.home
  (:require [compojure.core :refer :all]
            [build-fail-tracker.views.layout :as layout]))

(defn home []
  (layout/common [:h1 "Hello World!"]))

(defroutes home-routes
  (GET "/" [] (home)))
