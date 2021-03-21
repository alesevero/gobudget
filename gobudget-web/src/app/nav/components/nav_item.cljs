(ns app.nav.components.nav-item
  (:require [app.nav.views.styles :refer [link]]))

(defn nav-item
  [{:keys [id href name dispatch active-nav]}]
  [:a (merge (link id active-nav)
             {:key id
              :href href
              :on-click dispatch})
   name])