(ns app.components.datepicker)

(defn datepicker
  [id values]
  [:input {:type "date"
           :id id
           :name id
           :on-change #(swap! values assoc id (js/Date.. (.. % -target -value)))
           :style {:border "1px solid #969cb3"
                   :border-radius "8px"
                   :background-color "#FFF"
                   :color "#969cb3"
                   :padding "8px 8px"}}])

(defn datepicker-label
  [label id-for]
  [:label {:for id-for
           :style {:color "#24695C"
                   :padding "0 0 4px 0"}}
   label])

(defn datepicker-with-label
  [label id values]
  [:div {:style {:display "flex"
                 :flex-direction "column"
                 :margin-bottom "16px"}}
   [datepicker-label label id]
   [datepicker id values]])

