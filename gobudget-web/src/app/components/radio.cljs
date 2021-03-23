(ns app.components.radio)

(defn radio
  [label name value option values selected?]
  [:div {:style {:margin-right "16px"
                 :color "#24695C"}}
   [:label
    [:input {:type "radio"
             :name name
             :value value
             :id option
             :checked selected?
             :on-change #(->> (.. % -target -value)
                              keyword
                              (swap! values assoc :type))
             :style {:margin-right "6px"}}]
    label]])
