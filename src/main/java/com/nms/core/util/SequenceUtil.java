package com.nms.core.util;

import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nms.core.dao.AccountMapper;

/**
 * 序列号服务工具类
 * @author cja
 * @date 2017年9月20日
 */
@Service
public class SequenceUtil {
	
	private DecimalFormat eightDf = new DecimalFormat("00000000");//8位序列号
	
	@Autowired
	private AccountMapper accountMapper;
	
	/**
	 * 根据账户类型获取账户的8位顺序号
	 * @param acctType
	 * @return
	 */
	public synchronized String getNextAcctSeqNo(String acctType) {
		String acctNo = accountMapper.getLastAcctNoByAcctType(acctType);
		int acctSeqNo = acctNo==null?0:Integer.parseInt(acctNo.substring(acctNo.length()-8, acctNo.length()));
		if(acctSeqNo == 99999999){
			acctSeqNo = 0;
		}
		return eightDf.format(acctSeqNo+1);
	}
	
	/**
	 * 根据帐号获取子账户的账户序号
	 * @param acctNo
	 * @return
	 */
	public synchronized String getNextSubAcctSeqNo(String acctNo) {
		String subAcctSeqNo = accountMapper.getLastSubAcctSeqNoByAcctNo(acctNo);
		int nextSubAcctSeqNo = subAcctSeqNo==null?1:(Integer.parseInt(subAcctSeqNo)+1);
		return eightDf.format(nextSubAcctSeqNo);
	}

}
