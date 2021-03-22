(ns app.auth.components.form-group)

(defn form-group
  [{:keys [id type values label]}]
  [:div {:style {:display "flex"
                 :flex-direction "column"
                 :margin-bottom "16px"}}
   [:label {:label-for id
            :style {:color "#24695C"}}
    label]
   [:input {:id id
            :type type
            :value (id @values)
            :on-change #(swap! values assoc id (.. % -target -value))
            :style {:border "0"
                    :border-radius "8px"
                    :background-color "#FFF"
                    :color "#969cb3"
                    :padding "8px 8px"}}]])
