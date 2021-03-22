(ns app.auth.views.styles)

(def container
  {:style {:width "100%"
           :padding "30px 0"
           :display "flex"
           :align-items "center"
           :justify-content "center"}})

(def auth-container
  {:style {:width "900px"
           :padding "30px 0"
           :display "flex"
           :align-items "flex-start"
           :justify-content "space-between"}})

(def side-title-container
  {:style {:display "flex"
           :flex-direction "column"}})

(def form-container
  {:style {:width "400px"}})

(def sign-up-link
  {:style {:font-size "12px"
           :text-decoration "none"
           :color "#C18E60"}})

(def auth-button
  {:style {:border "0"
           :border-radius "8px"
           :padding "8px"
           :background-color "#24695C"
           :color "#F0F2F5"}})
(defn error-message
  [message]
  [:p {:style {:font-size "16px"
               :color "#e83f5b"}} message])