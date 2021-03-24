(ns app.shared.utils)

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