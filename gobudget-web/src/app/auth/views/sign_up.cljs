(ns app.auth.views.sign-up
  (:require [reagent.core :as r]
            [re-frame.core :as rf]
            [app.auth.components.form-group :refer [form-group]]))

(defn sign-up
  []
  (let [initial-values {:first-name "" :last-name "" :email "" :password ""}
        values (r/atom initial-values)]
    (fn []
      [:div {:style {:width "100%"
                     :display "flex"
                     :flex-direction "column"
                     :justify-content "center"
                     :align-items "center"}}
       [:h1 {:style {:padding "16px"
                     :color "#969cb3"}} "Sign Up"]
       [:div {:style {:width "400px"}}
        [form-group {:id :first-name
                     :type "text"
                     :values values
                     :label "First Name"}]
        [form-group {:id :last-name
                     :type "text"
                     :values values
                     :label "Last Name"}]
        [form-group {:id :email
                     :type "email"
                     :values values
                     :label "Email"}]
        [form-group {:id :password
                     :type "password"
                     :values values
                     :label "Password"}]
        [:div {:style {:display "flex"
                       :justify-content "flex-end"}}
         [:button {:on-click #(rf/dispatch [:sign-up @values])
                   :style {:border "0"
                           :border-radius "8px"
                           :padding "6px"
                           :background-color "#24695C"
                           :color "#F0F2F5"}}
          "Sign up"]]]])))
