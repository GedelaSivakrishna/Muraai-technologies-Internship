    let newTask = document.getElementById("taskName");
    let addTaskBtn = document.getElementById("addBtn");
    let enterTaskErrorPara = document.getElementById("enterTaskErrorPara");
    let orderedTasksContainer = document.getElementById("orderedTasksContainer");

    addTaskBtn.addEventListener("click", () => {
        let task = DOMPurify.sanitize(newTask.value);
        task = task.trim();
        console.log("Entered task = ", task);
        if(task === "") {
            enterTaskErrorPara.textContent = "Please enter the task";
            enterTaskErrorPara.style.color = "red";
        }
        else {
            let newTaskElement = document.createElement("li");
            let deleteTaskElement = document.createElement("button");
            deleteTaskElement.textContent = "Delete";
            deleteTaskElement.style.cssText = "padding: 5px; background-color: red; color: white; border: none; margin-left: 5px; hover: cursor: pointer;";
            newTaskElement.textContent = task;
            orderedTasksContainer.appendChild(newTaskElement);
            newTaskElement.appendChild(deleteTaskElement);
            newTask.value = "";

            deleteTaskElement.addEventListener("click", () => {
            let parentTaskELement = deleteTaskElement.parentNode;
            orderedTasksContainer.removeChild(parentTaskELement);
            })

            deleteTaskElement.addEventListener("mouseover", () => {
                deleteTaskElement.classList.add("hover-effect");
            })
        }
    })

    newTask.addEventListener("input", () => {
        enterTaskErrorPara.textContent = "";
    })