(ns app.auth.views.log-in
  (:require [app.components.form-group :refer [form-group]]
            [app.auth.views.styles :refer [container
                                           auth-container
                                           side-title-container
                                           form-container
                                           auth-button
                                           sign-up-link
                                           error-message]]
            [reagent.core :as r]
            [re-frame.core :as rf]))

(defn side-title
  []
  [:div side-title-container
   [:div
    [:img {:src "assets/logo.svg"
           :alt "GoBudget logo"
           :width "300px"}]]
   [:div
    [:p {:style {:color "#969cb3"}}
     "Take your money management to the next level."]]])

(defn form
  []
  (let [initial-values {:email "alexandre@example.com"
                        :password "password"}
        values (r/atom initial-values)]
    (fn []
      [:div form-container
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
        [:a (merge {:href "#sign-up"
                    :on-click #(rf/dispatch [:set-active-nav :sign-up])}
                   sign-up-link)
         "New to GoBudget? Create an account!"]
        [:button (merge {:on-click #(rf/dispatch [:log-in @values])}
                        auth-button)
         "Sign in"]]])))

(defn log-in
  []
  (let [{:keys [email]} @(rf/subscribe [:errors])]
    [:div container
     [:div auth-container
      [side-title]
      [:div {:style {:display "flex"
                     :flex-direction "column"}}
       (when (not (nil? email))
         (error-message email))
       [form]]]]))
