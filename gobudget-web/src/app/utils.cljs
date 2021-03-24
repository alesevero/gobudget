(ns app.utils
  (:require [cljs-time.format :as format]))

(def formatter (format/formatter :basic-date))

(defn format-date
  [date]
  (-> date
      .toLocaleString
      (.split "T")
      first))

(defn format-price
  [amount]
  (str
   "$"
   (-> (js/Intl.NumberFormat.)
       (.format amount))))

(defn price-color
  [amount]
  (if (> amount 0)
    "#00876E"
    "#D84B42"))

