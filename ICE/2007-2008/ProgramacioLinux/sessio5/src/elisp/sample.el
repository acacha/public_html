;; a simple example of manipulating the current Emacs edit buffer
;;
;; Load this function by either pasting it in to your ~/.emacs
;; file, or M-x load-file.
;;
;; Execute by M-: (sample)
;;

(defun sample ()
  (let* ((txt (buffer-string))
         (len (length txt))
         (x nil))
    (goto-char 0)
    (dotimes (n len)
      ;; see if the next character is a number 0, 1, .. 9
      (setq x (char-after))
      (if x
          (let ()
            (setq x (char-to-string (char-after)))
            (if x
                (let ()
                  (if (equal x "0") (replace-char "ZERO"))
                  (if (equal x "1") (replace-char "ONE"))
                  (if (equal x "2") (replace-char "TWO"))
                  (if (equal x "3") (replace-char "THREE"))
                  (if (equal x "4") (replace-char "FOUR"))
                  (if (equal x "5") (replace-char "FIVE"))
                  (if (equal x "6") (replace-char "SIX"))
                  (if (equal x "7") (replace-char "SEVEN"))
                  (if (equal x "8") (replace-char "EIGHT"))
                  (if (equal x "9") (replace-char "NINE"))))))
      ;; move the text pointer forward
      (forward-char))))

(defun replace-char (s)
  (delete-char 1)
  (insert s))


	