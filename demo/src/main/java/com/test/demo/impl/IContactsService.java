package com.test.demo.impl;

import java.util.List;

public interface IContactsService {

    List<String> findAllByContactType(Long id, String contactType);
}
