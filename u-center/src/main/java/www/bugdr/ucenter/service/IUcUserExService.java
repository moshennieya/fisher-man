package www.bugdr.ucenter.service;

import www.bugdr.common.response.R;

public interface IUcUserExService {
    R sendEmailCode(String verifition, String emaillAddress, boolean mustRegister);
}
