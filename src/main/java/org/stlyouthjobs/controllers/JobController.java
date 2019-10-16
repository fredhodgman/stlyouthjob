package org.stlyouthjobs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.stlyouthjobs.models.Job;
import org.stlyouthjobs.models.data.JobDao;

import javax.validation.Valid;

@Controller
@RequestMapping("job")
public class JobController {

    @Autowired
    private JobDao jobDao;

    @RequestMapping(value="")
    public String index(Model model){
        model.addAttribute("jobs", jobDao.findAll());
        model.addAttribute("title", "List of Jobs");

        return "job/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "Add Job");
        model.addAttribute("jobTitle", "Add Job Title");
        model.addAttribute("address", "Add Address");
        model.addAttribute("jobCategory", "Select Job Category");
        model.addAttribute("jobSummary", "Add Job Summary");
        model.addAttribute("location", "Add Location");
        model.addAttribute("schedule", "Add Schedule");
        model.addAttribute("positionType", "Add Position Type");
        model.addAttribute("numOfPositions", "Add Number of Positions");
        model.addAttribute("dressCode", "Add Dress Code");
        model.addAttribute("payRate", "Add Pay Rate");
        model.addAttribute("closingDate", "Add Closing Date");
        model.addAttribute(new Job());

        return "job/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processJobAdd(Model model, @ModelAttribute @Valid Job newJob, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("jobTitle", "Add Job Title");
            model.addAttribute("address", "Add Address");
            model.addAttribute("jobCategory", "Select Job Category");
            model.addAttribute("jobSummary", "Add Job Summary");
            model.addAttribute("location", "Add Location");
            model.addAttribute("schedule", "Add Schedule");
            model.addAttribute("positionType", "Add Position Type");
            model.addAttribute("numOfPositions", "Add Number of Positions");
            model.addAttribute("dressCode", "Add Dress Code");
            model.addAttribute("payRate", "Add Pay Rate");
            model.addAttribute("closingDate", "Add Closing Date");
            return "job/add";
        }
        jobDao.save(newJob);

        return "redirect:/cheese";
    }

   @RequestMapping(value = "edit/{jobId}", method = RequestMethod.GET)
    public String editJobDisplay(Model model, @PathVariable int jobId) {

        model.addAttribute("title", "Edit Job");
        model.addAttribute("job", jobDao.findOne(jobId));

        return "job/edit";
    }

    @RequestMapping(value = "edit/{jobId}", method = RequestMethod.POST)
    public String processJobEditForm(Model model, @PathVariable int jobId, @ModelAttribute @Valid Job newJob, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job");
            //model.addAttribute("job", jobDao.findOne(jobId));

            return "job/edit";
        }

        Job editedJob = jobDao.findOne(jobId);
        editedJob.setJobTitle(newJob.getJobTitle());
        editedJob.setAddress(newJob.getAddress());
        editedJob.setJobCategory(newJob.getJobCategory());
        editedJob.setLocation(newJob.getLocation());
        editedJob.setSchedule(newJob.getSchedule());
        editedJob.setJobSummary(newJob.getJobSummary());
        editedJob.setPositionType(newJob.getPositionType());
        editedJob.setNumOfPositions(newJob.getNumOfPositions());
        editedJob.setDressCode(newJob.getDressCode());
        editedJob.setPayRate(newJob.getPayRate());
        editedJob.setClosingDate(newJob.getClosingDate());
        jobDao.save(editedJob);

        return "redirect:/job";
    }

}