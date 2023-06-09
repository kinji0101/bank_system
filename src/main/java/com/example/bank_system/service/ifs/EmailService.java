package com.example.bank_system.service.ifs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.example.bank_system.entity.Loan;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;

	// 獲取貸款表的用戶郵箱
	public void sendBillingStatements(List<Loan> loans) {
		for (Loan loan : loans) {
			String email = loan.getBank().getEmail();
			String statement = generateBillingStatement(loan);
			//html的樣式
			String body = "<html><body style=\"text-align:center;\"><h1>本期帳單</h1>" + "<p style=\"font-size:16px;\">"
					+ hideDecimal(statement) + "</p>" + "<p><a href=\"繳款連結\">前往繳款</a></p>" + "</body></html>";

			sendEmail(email, "Monthly Billing Statement", body);

		}
	}

	// 取得貸款資料
	private String generateBillingStatement(Loan loan) {
		String card = loan.getBank().getCard();
		String name = loan.getBank().getName();
		Integer id = loan.getId();
		double loanAmount = loan.getLoan();
		double loanRate = loan.getLoanRate();
		double installmentAmount = installmentAmount(loan);

		// 設置郵件內容
		StringBuilder statementBuilder = new StringBuilder();
		statementBuilder.append("卡號:").append(card).append("<br>");
		statementBuilder.append("姓名:").append(name).append("<br><br>");
		statementBuilder.append("繳款代碼:").append(id).append("<br><br>");
		statementBuilder.append("本期本金: $").append(loanAmount).append("<br>");
		statementBuilder.append("本期利息: $").append(loanRate).append("<br>");
		statementBuilder.append("本期應繳金額: $").append(installmentAmount).append("<br>");

		return statementBuilder.toString();
	}

	// 隱藏小數點後的數字並換行
	private String hideDecimal(String statement) {
		return statement.replaceAll("\\.\\d+", "<br>");
	}

	// 計算本期金額
	private double installmentAmount(Loan loan) {
		double loanAmount = loan.getLoan();
		double loanRate = loan.getLoanRate();
		int installments = loan.getInstallments();

		// 根據貸款金額、貸款利率和分期期數計算利息金額
		double installmentAmount = (loanAmount + loanRate) / installments;

		return installmentAmount;
	}

	// 使用JavaMailSender接口發送郵件
	public void sendEmail(String toEmail, String subject, String body) {
		try {
			MimeMessagePreparator preparator = mimeMessage -> {
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				messageHelper.setFrom("sr123692010@gmail.com");
				messageHelper.setTo(toEmail);
				messageHelper.setSubject(subject);

				// 設置郵件内容為 HTML 格式
				messageHelper.setText(body, true);
			};

			mailSender.send(preparator);

			System.out.println("Email sent successfully to: " + toEmail);
		} catch (MailException e) {
			System.out.println("Failed to send email to: " + toEmail);
			e.printStackTrace();
		}
	}

}
