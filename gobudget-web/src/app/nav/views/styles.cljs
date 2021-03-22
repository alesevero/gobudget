(ns app.nav.views.styles)

(def container
  {:style {:width "100%"
           :margin "0 auto"
           :padding "30px 0"
           :display "flex"
           :flex-direction "row"
           :align-items "center"
           :justify-content "space-between"}})

(def header
  {:style {:width "100%"
           :display "flex"
           :justify-content "flex-end"
           :padding "0 20px"}})

(defn link
  [id active-nav]
  {:style {:color "#C18E60"
           :text-decoration "none"
           :font-size "16px"
           :transition "opacity 0.2s"
           :padding "8px"
           :font-weight "normal"
           :border-bottom (when (= active-nav id) "2px solid #24695C")
           :hover {:opacity "0.6"}}})

(defn profile-link
  [active-nav]
  {:style {:border (if (= :profile active-nav)
                     "2px solid #24695C"
                     "1px solid #24695C")
           :border-radius "50px"
           :width "40px"
           :height "40px"
           :margin-left "8px"
           :display "flex"
           :align-items "center"
           :justify-content "center"}})

(def profile-img
  {:style {:width "35px"
           :height "35px"}})