(ns app.auth.views.log-in
  (:require [app.auth.components.form-group :refer [form-group]]
            [reagent.core :as r]
            [re-frame.core :as rf]))

(defn log-in
  []
  (let [initial-values {:email "" :password ""}
        values (r/atom initial-values)]
    (fn []
      [:div {:style {:width "100%"
                     :display "flex"
                     :flex-direction "column"
                     :justify-content "center"
                     :align-items "center"}}
       [:h1 {:style {:padding "16px"
                     :color "#969cb3"}}
        "Sign In"]
       [:div {:style {:width "400px"}}
        [form-group {:id :email
                     :type "email"
                     :values values
                     :label "Email"}]
        [form-group {:id :password
                     :type "password"
                     :values values
                     :label "Password"}]
        [:div {:style {:display "flex"
                       :justify-content "space-between"
                       :align-items "center"}}
         [:a {:href "#sign-up"
              :on-click #(rf/dispatch [:set-active-nav :sign-up])
              :style {:font-size "12px"
                      :text-decoration "none"
                      :color "#C18E60"}}
          "New to GoBudget? Create an account!"]
         [:button {:on-click #(rf/dispatch [:log-in @values])
                   :style {:border "0"
                           :border-radius "8px"
                           :padding "6px"
                           :background-color "#24695C"
                           :color "#F0F2F5"}}
          "Sign in"]]]])))
