package com.dili.assets.mapper;
import java.util.List;

import com.dili.assets.domain.BoothRent;
import com.dili.ss.base.MyMapper;

public interface BoothRentMapper extends MyMapper<BoothRent> {

    List<BoothRent> selectUsed();

    List<BoothRent> selectUnUsed();
}