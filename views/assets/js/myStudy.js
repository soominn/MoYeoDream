var selectCategory = document.getElementsByClassName("select-category");

      function handleClick(event) {

        if (event.target.classList[1] === "select-subject") {
          /* event.target.classList.remove("select-subject");
          $(".yellow-line").remove(); */
        } else {
            for (var i = 0; i < selectCategory.length; i++) {
                selectCategory[i].classList.remove("select-subject");
                $(".yellow-line").remove();
          }

          event.target.classList.add("select-subject");
          $(event.target).append(
            $('<div/>', {
              class: 'yellow-line',
            }),
          );
        }

      }

      function init() {
        for (var i = 0; i < selectCategory.length; i++) {
            selectCategory[i].addEventListener("click", handleClick);
        }
      }

      init();