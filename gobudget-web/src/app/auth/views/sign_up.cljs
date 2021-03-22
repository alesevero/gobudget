(ns app.auth.views.sign-up
  (:require [reagent.core :as r]
            [re-frame.core :as rf]
            [app.auth.components.form-group :refer [form-group]]
            [app.auth.views.styles :refer [container
                                           auth-container
                                           side-title-container
                                           form-container
                                           auth-button
                                           sign-up-link]]))

(defn sign-up
  []
  (let [initial-values {:first-name "" :last-name "" :email "" :password ""}
        values (r/atom initial-values)]
    (fn []
      [:div container
       [:div auth-container
        [:div side-title-container
         [:div
          [:img {:src "assets/logo.svg"
                 :alt "GoBudget logo"
                 :style {:width "300px"}}]]
         [:div
          [:p {:style {:color "#969cb3"}}
           "Take your money management to the next level."]]]
        [:div form-container
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
                        :align-items "center"
                        :justify-content "space-between"}}
          [:a (merge {:href "#sign-in"
                      :on-click #(rf/dispatch [:set-active-nav :sign-in])}
                     sign-up-link)
           "Already have an account? Sign in!"]
          [:button (merge {:on-click #(rf/dispatch [:sign-up @values])}
                          auth-button)
           "Sign up"]]]]])))
