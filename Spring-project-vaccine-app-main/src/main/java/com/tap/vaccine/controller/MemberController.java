package com.tap.vaccine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import com.tap.vaccine.RegisterEntity.MemberEntity;
import com.tap.vaccine.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;

	@RequestMapping("/setmember")
	public String setMemberDetails() {
		return "/member";
	}
	
	

	@RequestMapping("/getmember")
	public String getMemberDetails(@RequestParam String name, @RequestParam String gender, @RequestParam String dob,
			@RequestParam String idProof, @RequestParam String idProofNo, @RequestParam String vaccineType,
			@RequestParam String dose, Model model, HttpServletRequest request) {
		System.out.println("inside of controller getMemberDetails()");
		
		if (!memberService.validateName(name)) {
			model.addAttribute("name", "Enter the valid username");
			return "/member";
		}
		if (!memberService.validateGender(gender)) {
			model.addAttribute("gender", "Enter the valid gender");
			return "/member";
		}
		if (!memberService.validateDob(dob)) {
			model.addAttribute("dob", "Enter the valid dob");
			return "/member";
		}
		if (!memberService.validateIdProof(idProof)) {
			model.addAttribute("idProof", "Enter the valid idProof");
			return "/member";
		}
		if (!memberService.validateIdProofNo(idProofNo)) {
			model.addAttribute("idProofNo", "Enter the valid idProofNo");
			return "/member";
		}
		if (!memberService.validateVaccineType(vaccineType)) {
			model.addAttribute("vaccineType", "Enter the valid vaccineType");
			return "/member";
		}
		if (!memberService.validateDose(dose)) {
			model.addAttribute("dose", "Enter the valid dose");
			return "/member";
		}
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("Email");
		System.out.println(email);

		boolean isValidate = memberService.validate(name, gender, dob, idProof, idProofNo, vaccineType, dose,email);
		if (isValidate) {
			boolean Count = memberService.checkMemberCount(email);
			if (Count) {
				boolean isStored = memberService.storeDetails(name, gender, dob, idProof, idProofNo, vaccineType, dose,email);
				if(isStored) {
					model.addAttribute("responseMessage", "Member is successfully added ");
					return "/member";
				}
				else {
					model.addAttribute("responseMessage","Member is not added ....try again...");
					return "/member";
				}
			} else {
				model.addAttribute("Message", "your are exceeded the limit ");
				return "/member";
			}
		} else {
			model.addAttribute("responseMessage", " Enter valid details....");
			return "/member";
		}

	}

	/*
	 * @RequestMapping("/viewmembers") public ModelAndView getViewMembers()
	 * 
	 * { ModelAndView modelAndView = new ModelAndView("member");
	 * 
	 * List<MemberEntity> members = memberService.getAllMemberDetails();
	 * modelAndView.addObject("members", members); System.out.println(modelAndView);
	 * 
	 * return modelAndView;
	 * 
	 * }
	 */
	@RequestMapping(value = "/viewmembers")
	public String getAllAirport(Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userEmail= (String) session.getAttribute("Email");
		List<MemberEntity> Details = memberService.getAllMemberDetails(userEmail);
		System.out.println(userEmail);
		model.addAttribute("members", Details);

		return "/member";
	}
	@RequestMapping(value="/delete/{idProofNo}")
	public String delete(@PathVariable String idProofNo,Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userEmail= (String) session.getAttribute("Email");
		System.out.println("inside of the delete()");
		boolean isDeleted=memberService.deleteRecord(idProofNo,userEmail);
		if(isDeleted) {
			model.addAttribute("delete","Data is deleted");
		}else {
			model.addAttribute("delete","Data is not  deleted! try again ...");
		}
		
		
		return "/member";
		
	}
	@RequestMapping(value="/edit/{memberId}")
	public String Edit (@PathVariable int memberId,Model model)
	{
		System.out.println("invoked edit ()");
		MemberEntity entity = memberService.getDetails(memberId);
		model.addAttribute("ID", entity.getMemberId());
		model.addAttribute("NAME",entity.getName());
		model.addAttribute("GENDER", entity.getGender());
		model.addAttribute("DATE_OF_BIRTH", entity.getDob());
		model.addAttribute("ID_PROOF", entity.getIdProof());
		model.addAttribute("ID_PROOF_NO", entity.getIdProofNo());
		model.addAttribute("VACCINE_TYPE", entity.getVaccineType());
		model.addAttribute("DOSE", entity.getDose());
		return "/memberedit";
	}
	@RequestMapping(value="/update/{memberId}")
	public String update(@PathVariable int memberId,@RequestParam String name, @RequestParam String gender, @RequestParam String dob,
			@RequestParam String idProof, @RequestParam String idProofNo, @RequestParam String vaccineType,
			@RequestParam String dose, Model model, HttpServletRequest request)
	{
		System.out.println("invoked update()");
		
		if (!memberService.validateName(name)) {
			model.addAttribute("name", "Enter the valid username");
			return "/memberedit";
		}
		if (!memberService.validateGender(gender)) {
			model.addAttribute("gender", "Enter the valid gender");
			return "/memberedit";
		}
		if (!memberService.validateDob(dob)) {
			model.addAttribute("dob", "Enter the valid dob");
			return "/memberedit";
		}
		if (!memberService.validateIdProof(idProof)) {
			model.addAttribute("idProof", "Enter the valid idProof");
			return "/memberedit";
		}
		if (!memberService.validateIdProofNo(idProofNo)) {
			model.addAttribute("idProofNo", "Enter the valid idProofNo");
			return "/memberedit";
		}
		if (!memberService.validateVaccineType(vaccineType)) {
			model.addAttribute("vaccineType", "Enter the valid vaccineType");
			return "/memberedit";
		}
		if (!memberService.validateDose(dose)) {
			model.addAttribute("dose", "Enter the valid dose");
			return "/memberedit";
		}
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("Email");
		System.out.println(email);
		boolean isValidate = memberService.validate(name, gender, dob, idProof, idProofNo, vaccineType, dose,email);
		if(isValidate)
		{
			boolean isDetails = memberService.updateAllDetails(memberId,name, gender, dob, idProof, idProofNo, vaccineType, dose,email);
			if(isDetails)
			{
				model.addAttribute("delete", "Data is updated.");
				return "/member";
				
			}
			else {
				model.addAttribute("responseMessage","Data is not updated try again....");
				return "/memberedit";
				
			}
		}
		else {
			model.addAttribute("responseMessage", "Data is invalid ");
			return "/memberedit";
			
		}
	
	}
	
	
	

}
