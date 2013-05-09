import uk.ac.shu.webarch.eReg.*;
class BootStrap {

    def init = { servletContext ->
			
			println("BootStrap::init");


			//Setting test data for application first run.
			def test_instructor = Instructor.findByStaffId('0000t') ?: new Instructor(staffId:'0000t', name:'Test Instructor').save();

			def test_course = Course.findByCourseCode('c0000') ?: new Course(courseCode:'c0000', 
																																			 courseName:'Test Course',
																																			 description:'An initial test course for eReg. Feel free to delete.').save();
  
			def test_student = Student.findByStudentNumber('00000000') ?: new Student(fullStudentName:'Test Student', studentNumber:'00000000', notes:'A test student. Feel free to delete.').save();
			
			def test_class = RegClass.findByCode('s0000') ?: new RegClass(name:'Test Class', code:'s0000', classInstructor:test_instructor, course:test_course).save();
			//End of test data.  
		}

    def destroy = {
    }
}
