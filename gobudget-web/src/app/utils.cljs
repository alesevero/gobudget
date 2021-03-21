(ns app.utils)

(defn format-date
  [date]
  (-> date
      .toISOString
      (.split "T")
      first))

(defn format-price
  [amount]
  (str
   (when (= type :outcome) "-")
   "$"
   (-> (js/Intl.NumberFormat.)
       (.format amount))))

(defn price-color
  [amount]
  (if (> amount 0)
    "#00876E"
    "#D84B42"))