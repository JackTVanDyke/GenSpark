const myForm = document.getElementById("contactUs");
// VALIDATE FORM
function checkInputs() {
  var name = document.getElementsByTagName("input")[0].value.trim();
  var nameTest = name.search(/[a-zA-Z]/g);
  if (nameTest == -1 || name == "") {
    alert("Please enter a valid name.");
  }
  var email = document.getElementsByTagName("input")[1].value.trim();
  if (
    /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(
      email
    ) == false ||
    email == ""
  ) {
    alert("Please enter a valid email.");
  }
  var phone = document.getElementsByTagName("input")[2].value.trim();
  var phoneTest = phone.search(/[0-9]/g);
  if (phoneTest.length < 10) {
    alert("Please enter a valid phone number.");
  }
  var subject = document.getElementsByTagName("input")[3].value.trim();
  var subjectTest = subject.search(/[a-zA-Z]/g);
  if (subjectTest == -1 || subject == "") {
    alert("Please enter a valid subject.");
  }
  var message = document.getElementsByTagName("textarea")[0].value.trim();
  if (message.length < 10) {
    alert("Please enter a valid message.");
  }
}
// SUBMIT FORM, SAVE DATA TO LOCAL STORAGE //
myForm.addEventListener("submit", (e) => {
  checkInputs();
  e.preventDefault();
  const formData = new FormData(myForm);
  const nameDataVal = formData.get("name");
  const emailDataVal = formData.get("email");
  const phoneDataVal = formData.get("phonenum");
  const subjectDataVal = formData.get("subject");
  const messageDataVal = formData.get("usermessage");
  localStorage.setItem("nameData", nameDataVal);
  localStorage.setItem("emailData", emailDataVal);
  localStorage.setItem("phoneData", phoneDataVal);
  localStorage.setItem("subjectData", subjectDataVal);
  localStorage.setItem("messageData", messageDataVal);
  // OPEN NEW WINDOW THAT DISPLAYS FORM DATA  //
  //   document.querySelector(".btn").addEventListener("click", () => {
  if (
    formData.get("name") != "" &&
    formData.get("email") != "" &&
    formData.get("phonenum") != "" &&
    formData.get("subject") != "" &&
    formData.get("usermessage") != ""
  ) {
    window.open("html/contactdata.html", "_blank");
  }
  //   });
});
