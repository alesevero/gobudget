(ns app.validation.spec
  (:require [cljs.spec.alpha :as s]))

(s/def ::checked boolean)
(s/def ::selected not-empty)

(s/def ::name-not-empty not-empty)

(s/def ::email (s/and string? (partial re-matches #"^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,63}$")))

(s/def ::password-not-empty not-empty)
(s/def ::password-length #(<= 6 (count %)))
(s/def ::password (s/and string? ::password-not-empty ::password-length))

(s/def ::checkbox-with-value (s/and ::checked))
(s/def ::checkbox-without-value (s/and ::checked))

(s/def ::select-one (s/and ::selected #{"green"}))
(s/def ::select-multiple (partial some #{"cat"}))

(s/def ::radio #{"red"})

(s/def ::sign-up-form (s/keys :req-un [::email ::password ::name-not-empty]))
