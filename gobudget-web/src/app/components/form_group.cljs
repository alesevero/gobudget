(ns app.components.form-group)

(defn form-group
  [{:keys [id type values label]}]
  [:div {:style {:display "flex"
                 :flex-direction "column"
                 :margin-bottom "16px"}}
   [:label {:labelfor id
            :style {:color "#24695C"
                    :padding "0 0 4px 0"}}
    label]
   [:input {:id id
            :type type
            :value (id @values)
            :on-change #(swap! values assoc id (.. % -target -value))
            :style {:border "1px solid #969cb3"
                    :border-radius "8px"
                    :background-color "#FFF"
                    :color "#333"
                    :padding "8px 8px"}}]])
