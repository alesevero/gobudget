(ns app.components.navigation.styles)

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
