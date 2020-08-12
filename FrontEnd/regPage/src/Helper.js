const succ = 2;
const error = 1;
function helper(input1, input2, message) {
  if (input1 == 1) {
    errorDisplayer(input2, message);
  } else if (input1 == 2) {
    succDisplayer(input2);
  } else if (input1 == 4) {
    emailValidator(input2);
  } else {
    passwordMatcher(input2, message);
  }
}
function errorDisplayer(input, message) {
  const cont = input.parentElement;
  cont.className = "comps error";
  const small = cont.querySelector("small");
  small.innerText = message;
}

function succDisplayer(input) {
  const cont = input.parentElement;
  cont.className = "comps success";
}

function passwordMatcher(pass, pass2) {
  if (pass.value != pass2.value) {
    helper(1, pass2, "Password do not match");
  }
}
function emailValidator(input) {
  const regx = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
  if (regx.test(input.value)) {
    helper(succ, input);
  } else {
    helper(error, input, "Ivalid Email");
  }
}

export default helper;
