(ns app.components.radio)

(defn radio
  [label name value values]
  [:div {:style {:margin-right "16px"
                 :padding "4px 0 0 0"
                 :color "#24695C"}}
   [:label
    [:input {:type "radio"
             :name name
             :value value
             :id value
             :checked (= value (:type @values))
             :on-change #(->> (.. % -target -value)
                              keyword
                              (swap! values assoc :type))
             :style {:margin-right "6px"}}]
    label]])
