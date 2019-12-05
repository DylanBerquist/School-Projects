&main;
sub main{
  print "Please enter the number for the program you'd like to run: \n";
  print "1 - Quadratic\n2 - Prime\n3 - Pi Calculating\n4 - Taxes\n5 - Password Generation\n6 - Test Scores\n7 - File Sorting\n8 - Name Frequency\n9 - Powers\n10 - Factorials\n11 - Sorting Arrays\n12 - Min/Max Values\n13 - Positives & Fractionals\n14 - EmuId & EmuWeb\n15 - Whitespace & Area Code\n\n";

  $input = <STDIN>;
  if($input == 1){
    &quadratic;
    &main;
  }elsif($input == 2){
    &prime;
    &main;
  }elsif($input == 3){
    &pi;
    &main;
  }elsif($input == 4){
    &tax;
    &main;
  }elsif($input == 5){
    &idpassword;
    &main;
  }elsif($input == 6){
    &score;
    &main;
  }elsif($input == 7){
    &filesort;
    &main;
  }elsif($input == 8){
    &frequency;
    &main;
  }elsif($input == 9){
    print "Please Enter the base number: \n";
    $base = <STDIN>;

    print "Please enter the exponent: \n";
    $exp = <STDIN>;

    $printable = &power($base, $exp);
    print "Resulting value: $printable\n\n";
    &main;
  }elsif($input == 10){
    print "Please enter the number you'd like to calculate the factorial for: \n";
    $fact = <STDIN>;

    $printable = &factorial($fact);
    print "Resulting factorial: $printable\n\n";
    &main;
  }elsif($input == 11){
    @array = (2, 5, 1, 4);
    print "\nInitial array: @array";

    @array = &sort(@array);
    print "\nResulting array: @array \n\n";
    &main;
  }elsif($input == 12){
    @array = (2, 5, 1, 4);
    &minmax(@array, $min, $max);
    &main;
  }elsif($input == 13){
    &positives;
    &fractionals;
    &main;
  }elsif($input == 14){
    &emuid;
    &emuweb;
    &main;
  }elsif($input == 15){
    &whitespace;
    &areacode;
    &main;
  }else{
    print "Exiting program, Goodbye!\n";
  }
}
sub quadratic{
  print "Please enter coefficient A: ";
  $A = <STDIN>;
  print "\nPlease enter coefficient B: ";
  $B = <STDIN>;
  print "\nPlease enter coefficient C: ";
  $C = <STDIN>;

  if((($B*$B)-(4*$A*$B)) < 0){
    print "\nThis equation has no solutions!!\n\n";
  }else{
    $solutionOne = (((-1*$B) + sqrt(($B*$B) - (4*$A*$B))) / (2*$A));
    $solutionTwo = (((-1*$B) - sqrt(($B*$B) - (4*$A*$B))) / (2*$A));
    print "\nSolution #1: $solutionOne\nSolution #2: $solutionTwo\n\n";
  }
}
sub prime{
  print "Please enter your number: ";
  $primeNumber = <STDIN>;
  $primeFlag = 0;

  for($count = 2; $count < $primeNumber; $count++){
    if(($primeNumber % $count) == 0){
      $primeFlag = 1;
    }
  }

  if($primeFlag == 0){
    print "\nYou entered a prime number!\n\n";
  }else{
    print "\nThe number you entered is not prime..\n\n";
  }
}
sub pi{
  print "Please enter the number for which you'd like to calculate Pi: ";
  $n = <STDIN>;
  $count = -3;
  $number = 1;

  for($i = 0; $i < $n; $i++){
    $number = $number + (1/$count);

    if(($i % 2) == 0){
      $count = ($count * -1) + 2;
    }else{
      $count = ($count + 2) * -1;
    }
  }

  $pi = 4 * $number;
  print "\nYour Pi calculation: $pi \n\n";
}
sub tax{
  print "Please enter your income: ";
  $income = <STDIN>;
  print "\nPlease enter your marital status: ";
  $status = <STDIN>;
  print "\nPlease enter your state residency: ";
  $residency = <STDIN>;

  if($residency =~ /i/i){
    if($status =~ /single/i){
      if($income < 30000){
        print "\nYour tax rate is 20%\n\n";
      }else{
        print "\nYour tax rate is 25%\n\n";
      }
    }elsif($status =~ /married/i){
      if($income < 50000){
        print "\nYour tax rate is 10%\n\n";
      }else{
        print "\nYour tax rate is 15%\n\n";
      }
    }
  }elsif($residency =~ /o/i){
    if($status =~ /single/i){
      if($income < 30000){
        print "\nYour tax rate is 17%\n\n";
      }else{
        print "\nYour tax rate is 22%\n\n";
      }
    }elsif($status =~ /married/i){
      if($income < 50000){
        print "\nYour tax rate is 7%\n\n";
      }else{
        print "\nYour tax rate is 12%\n\n";
      }
    }
  }
}
sub idpassword{
  print "Please enter your first name: ";
  $firstName = <STDIN>;
  print "\nPlease enter your last Name: ";
  $lastName = <STDIN>;

  @firstAr = split(//, $firstName);
  @lastAr = split(//, $lastName);

  $userID = uc(@firstAr[0].$lastName);
  $userPassword = uc(@firstAr[0].@firstAr[length($firstName)-2].@lastAr[0].@lastAr[1].@lastAr[2]).(length($firstName)-1).(length($lastName)-1);

  print "\nYour user ID: $userID";
  print "\nYour password: $userPassword\n\n";
}
sub score{
  while($student ne "q" && $student ne "Q"){
    print "Please enter student information: \n";
    $student = <STDIN>;
    chomp($student);

    @studentInfo = split(/ /, $student);
    push(@studentNames, @studentInfo[0]);
    push(@studentGrades, @studentInfo[1]);
  }

  $len = @studentGrades;
  @min = (@studentNames[0], @studentGrades[0]);
  $avg = 0;
  @max = (@studentNames[0], @studentGrades[0]);

  for($i = 0; $i < $len-1; $i++){
    $avg = $avg + @studentGrades[$i];

    if(@studentGrades[$i] < @min[1]){
      @min[0] = @studentNames[$i];
      @min[1] = @studentGrades[$i];
    }elsif(@studentGrades[$i] > @max[1]){
      @max[0] = @studentNames[$i];
      @max[1] = @studentGrades[$i];
    }
  }

  $avg = ($avg/($len-1));
  print "\nThe average score: $avg";
  print "\nThe Minimum Score is @min[1], scored by @min[0]";
  print "\nThe Maximum Score is @max[1], scored by @max[0]\n\n";
}
sub filesort{
  print "Please enter the file that you would like to sort: \n";
  $fileName = <STDIN>;
  chomp($fileName);
  open(FIN, "<$fileName");

  while($line = <FIN>){
    @lineAr = split(/ /, $line);
    chomp(@lineAr[2]);

    push(@fsLastNames, @lineAr[0]);
    push(@fsFirstNames, @lineAr[1]);
    push(@fsGpas, @lineAr[2]);
  }
  close(FIN);

  $len = @fsLastNames;
  for($i = 0; $i < $len; $i++){
    for($j = 0; $j < $len; $j++){
        if(@fsLastNames[$j] gt @fsLastNames[$i]){
          $temp = @fsLastNames[$i];
          @fsLastNames[$i] = @fsLastNames[$j];
          @fsLastNames[$j] = $temp;

          $temp = @fsFirstNames[$i];
          @fsFirstNames[$i] = @fsFirstNames[$j];
          @fsFirstNames[$j] = $temp;

          $temp = @fsGpas[$i];
          @fsGpas[$i] = @fsGpas[$j];
          @fsGpas[$j] = $temp;
      }
    }
  }

  open(FOUT, ">filesortOutput.txt");
  for($i = 0; $i < $len; $i++){
    print FOUT "@fsLastNames[$i] @fsFirstNames[$i] @fsGpas[$i]\n";
  }
  close(FOUT);
  print "\nYour file has been sorted, check (filesortOutput.txt) for the results!\n\n";
}
sub frequency{
  print "Please enter the file that you would like to sort: \n";
  $fileName = <STDIN>;
  chomp($fileName);
  open(FIN, "<$fileName");

  while($line = <FIN>){
    @lineAr = split(/ /, $line);
    chomp(@lineAr[1]);

    push(@freqLastNames, @lineAr[0]);
    push(@freqFirstNames, @lineAr[1]);
  }
  close(FIN);

  $len = @freqLastNames;
  for($i = 0; $i < $len; $i++){
    $count = 0;
    for($j = 0; $j < $len; $j++){
      if(@freqLastNames[$j] eq @freqLastNames[$i]){
        $count++;
      }
    }

    push(@frequencies, @freqLastNames[$i]);
    push(@frequencies, $count);
  }

  for($i = 0; $i < $len; $i = $i + 2){
    print "\n@frequencies[$i] appears @frequencies[$i+1] times\n";
  }
  print "\n";
}
sub power{
  my $result = 1;
  for($i = 0; $i < $_[1]; $i++){
    $result = $result * $_[0];
  }
  return $result;
}
sub factorial{
  if($_[0] == 1){
    return 1;
  }elsif($_[0] <= 0){
    return 0;
  }else{
    return ($_[0] * &factorial($_[0]-1));
  }
}
sub sort{
  @AR = @_;
  $len = @AR;

  for($i = 0; $i < $len; $i++){
    for($j = 0; $j < $len; $j++){
      if(@AR[$j] > @AR[$i]){
        $temp = @AR[$i];
        @AR[$i] = @AR[$j];
        @AR[$j] = $temp;
      }
    }
  }
  return @AR;
}
sub minmax{
  @AR = @_;
  $len = @AR;
  $len = ($len - 2);

  $min = @AR[0];
  $max = @AR[0];

  for($i = 1; $i < $len; $i++){
    if($min > @AR[$i]){
      $min = @AR[$i];
    }elsif($max < @AR[$i]){
      $max = @AR[$i];
    }
  }

  print "\nMinimum value: $min\n";
  print "\nMaxmimum value: $max\n\n";
}
sub positives{
  print "Please enter the file that you would like to scan(positives): \n";
  $fileName = <STDIN>;
  chomp($fileName);
  open(FIN, "<$fileName");

  while($line = <FIN>){
    @lineAr = split(/ /, $line);
    chomp(@lineAr[0]);

    push(@posWords, @lineAr[0]);
  }
  close(FIN);

  print "Please enter the file that you would like to output to(positives): \n";
  $filename = <STDIN>;
  chomp($filename);
  open(FOUT, ">$filename");

  $len = @posWords;
  for($i = 0; $i < $len; $i++){
    @current = split(//, @posWords[$i]);
    if(@current[0] ne "0"){
      print FOUT "@posWords[$i] \n";
    }
  }
  close(FOUT);
  print "The output has been printed to ($filename)!\n\n";
}
sub fractionals{
  print "Please enter the file that you would like to scan(fractionals): \n";
  $fileName = <STDIN>;
  chomp($fileName);
  open(FIN, "<$fileName");

  while($line = <FIN>){
    @lineAr = split(/ /, $line);
    chomp(@lineAr[0]);

    push(@posWords, @lineAr[0]);
  }
  close(FIN);

  print "Please enter the file that you would like to output to(fractionals): \n";
  $filename = <STDIN>;
  chomp($filename);
  open(FOUT, ">$filename");

  $len = @posWords;
  for($i = 0; $i < $len; $i++){
    if(@posWords[$i] =~ /^0\./){
      print FOUT "@posWords[$i] \n";
    }
  }
  close(FOUT);
  print "The output has been printed to ($filename)!\n\n";
}
sub emuid{
  print "Please enter the file that you would like to scan(emuid): \n";
  $fileName = <STDIN>;
  chomp($fileName);
  open(FIN, "<$fileName");

  while($line = <FIN>){
    @lineAr = split(/ /, $line);
    chomp(@lineAr[0]);

    push(@posWords, @lineAr[0]);
  }
  close(FIN);

  print "Please enter the file that you would like to output to(emuid): \n";
  $filename = <STDIN>;
  chomp($filename);
  open(FOUT, ">$filename");

  $len = @posWords;
  for($i = 0; $i < $len; $i++){
    @current = split(//, @posWords[$i]);
    if(@posWords[$i] =~ /^e00/i && @current >= 8){
      print FOUT "@posWords[$i] \n";
    }
  }
  close(FOUT);
  print "The output has been printed to ($filename)!\n\n";
}
sub emuweb{
  print "Please enter the file that you would like to scan (emuweb): \n";
  $fileName = <STDIN>;
  chomp($fileName);
  open(FIN, "<$fileName");

  while($line = <FIN>){
    @lineAr = split(/ /, $line);
    chomp(@lineAr[0]);

    push(@posWords, @lineAr[0]);
  }
  close(FIN);

  print "Please enter the file that you would like to output to(emuweb): \n";
  $filename = <STDIN>;
  chomp($filename);
  open(FOUT, ">$filename");

  $len = @posWords;
  for($i = 0; $i < $len; $i++){
    if(@posWords[$i] =~ /^www\.emich\.edu/ && @posWords[$i] =~ /\.html$/){
      print FOUT "@posWords[$i] \n";
    }
  }
  close(FOUT);
  print "The output has been printed to ($filename)!\n\n";
}
sub whitespace{
  print "Please enter the file that you would like to scan(whitespace): \n";
  $fileName = <STDIN>;
  chomp($fileName);
  open(FIN, "<$fileName");

  while($line = <FIN>){
    $line =~ s/\s+/ /;
    @lineAr = split(/ /, $line);
    chomp(@lineAr[1]);

    push(@posWords, @lineAr[0]);
    push(@posWords, @lineAr[1]);
  }
  close(FIN);

  print "Please enter the file that you would like to output to(whitespace): \n";
  $filename = <STDIN>;
  chomp($filename);
  open(FOUT, ">$filename");

  $len = @posWords;
  for($i = 0; $i < $len; $i = $i + 2){
    print FOUT "@posWords[$i] @posWords[$i+1]\n";
  }
  close(FOUT);
  print "The output has been printed to ($filename)!\n\n";
}
sub areacode{
  print "Please enter the file that you would like to scan(areacode): \n";
  $fileName = <STDIN>;
  chomp($fileName);
  open(FIN, "<$fileName");

  while($line = <FIN>){
    @lineAr = split(/ /, $line);
    chomp(@lineAr[1]);

    push(@codeNames, @lineAr[0]);
    push(@codeNums, @lineAr[1]);
  }
  close(FIN);

  print "Please enter the file that you would like to output to(areacode): \n";
  $filename = <STDIN>;
  chomp($filename);
  open(FOUT, ">$filename");

  $len = @codeNames;
  for($i = 0; $i < $len; $i++){
    @codeNums[$i] =~ s/715/692/;
    print FOUT "@codeNames[$i] @codeNums[$i]\n";
  }
  close(FOUT);
  print "The output has been printed to ($filename)!\n\n";
}
