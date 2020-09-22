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
    cont.className = 'comps error';
    const small = cont.querySelector('small');
    small.innerText = message;
}

function succDisplayer(input) {
    const cont = input.parentElement;
    cont.className = 'comps success';
}

function passwordMatcher(pass, pass2) {
    if (!passwordProvider(pass.value, pass2.value)) {
        helper(1, pass2, 'Password do not match');
    }
}

function emailValidator(input) {
    if (emailProvider(input.value)) {
        helper(succ, input);
    } else {
        helper(error, input, 'Ivalid Email');
    }
}

export const passwordProvider = (p1, p2) => p1 === p2;

export const emailProvider = (string) => {
    const regx = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    return regx.test(string);
}

export const lengthValidatorProvider = (string, min, max) => string.length < min ? 1 : string.length > max ? 2 : 0

export default helper;
