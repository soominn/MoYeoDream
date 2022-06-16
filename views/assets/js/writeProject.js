/* select Box */
function toggleSelect(selectBox){
    selectBox.classList.toggle("active");
}

function selectOption(option){
    console.log("----------function-----------");
    const selectBox = option.closest(".selectBox");
    console.log(selectBox);
    const selectVal = selectBox.querySelector(".selectedValue");
    console.log(selectVal);
    selectVal.textContent = option.textContent;
    console.log("selected option : "+option.textContent);
}

const selectArr = document.querySelectorAll(".selectBox");

selectArr.forEach(select => {
    select.addEventListener("click", function(e){
        const target = e.target;
        const option = target.classList.contains(".option");
        
        console.log(target);
        console.log(option);

        if(option){
            console.log(option.textContent);
            selectOption(target);
        }
        
        toggleSelect(select);
    });
});