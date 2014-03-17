(ns reporting-example.reports
  (:require [clj-pdf.core :refer [pdf template]]
            [reporting-example.models.db :as db]))

(def employee-template
  (template [$name $occupation $place $country]))
(defn gen-employee-report []
  (pdf
   [{:header "Employee List"}
    (into [:table
           {:border false
            :cell-border false
            :header [{:color [0 150 150]} "Name" "Occupation" "Place" "Country"]}]
          (employee-template (db/read-employees)))]
   "report.pdf"))

(defn gen-report []
  (pdf
   [{:header "Wow that was easy"}
    [:list
     [:chunk {:style :bold} "a bold item"]
     "another item"
     "yet another item"]
    [:paragraph "I'm a paragraph!"]]
   "doc.pdf"))
