const {passwordProvider, emailProvider, lengthValidatorProvider} = require('./Helper')

describe('Password Matcher', () => {
    test('Password Matcher exists', () => {
        expect(passwordProvider).toBeDefined();
    })
    test('Password Matcher works as expected', () => {
        expect(passwordProvider('password', 'password')).toBe(true);
        expect(passwordProvider('password', 'password2')).toBe(false);
    })
});

describe('Email Validator', () => {
    test('Email Validator exists', () => {
        expect(emailProvider).toBeDefined();
    })
    test('Email Validator works as expected', () => {
        expect(emailProvider('test@test.com')).toBe(true);
        expect(emailProvider('abcdefgh')).toBe(false);
    })
});

describe('Length Validator', () => {
    test('Length Validator exists', () => {
        expect(lengthValidatorProvider).toBeDefined();
    })
    test('Length Validator works as expected', () => {
        expect(lengthValidatorProvider('1', 3, 15)).toBe(1);
        expect(lengthValidatorProvider('12345678', 3, 6)).toBe(2);
        expect(lengthValidatorProvider('12345', 3, 8)).toBe(0);
    })
});