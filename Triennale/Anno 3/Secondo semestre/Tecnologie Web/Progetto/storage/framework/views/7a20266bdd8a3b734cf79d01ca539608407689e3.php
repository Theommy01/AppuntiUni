

<?php $__env->startSection('title', 'Registrazione'); ?>

<?php $__env->startSection('content'); ?>
    <!-- il wrapper è il contenitore che contiene il box della form di login -->
    <div class="wrapper wrapper-register">
        <!-- box che contiene la form di login -->
        <div class="form-box form-box-inputdialog login">
            <h2>Registrazione</h2>

            <!-- effettiva form di input -->
            <?php echo e(Form::open(array('route' => 'register', 'class' => 'contact-form'))); ?>

            <div class="form-row">
                <div class="form-left">
                    <?php echo e(Form::label('nome', 'Nome', ['class' => 'label-input'])); ?>

                    <?php echo e(Form::text('nome', '', ['class' => 'input', 'id' => 'nome', 'required' => 'required'])); ?>

                    <?php if($errors->first('nome')): ?>
                        <ul class="errors">
                            <?php $__currentLoopData = $errors->get('nome'); $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $message): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                                <li><?php echo e($message); ?></li>
                            <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                        </ul>
                    <?php endif; ?>

                    <?php echo e(Form::label('cognome', 'Cognome', ['class' => 'label-input'])); ?>

                    <?php echo e(Form::text('cognome', '', ['class' => 'input', 'id' => 'cognome', 'required' => 'required'])); ?>

                    <?php if($errors->first('cognome')): ?>
                        <ul class="errors">
                            <?php $__currentLoopData = $errors->get('cognome'); $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $message): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                                <li><?php echo e($message); ?></li>
                            <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                        </ul>
                    <?php endif; ?>

                    <?php echo e(Form::label('eta', 'Data di nascita', ['class' => 'label-input'])); ?>

                    <?php echo e(Form::date('eta', '', ['class' => 'input', 'id' => 'eta', 'rules' => 'date_format:d-m-Y', 'required' => 'required'])); ?>

                    <?php if($errors->first('eta')): ?>
                        <ul class="errors">
                            <?php $__currentLoopData = $errors->get('eta'); $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $message): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                                <li><?php echo e($message); ?></li>
                            <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                        </ul>
                    <?php endif; ?>

                    <?php echo e(Form::label('genere', 'Genere')); ?>


                    <?php echo e(Form::radio('genere', 'M', true, ['style' => 'display:inline;'])); ?>

                    <?php echo e(Form::label('genere', 'Maschio', ['style' => 'display:inline;'])); ?>

                    <?php echo e(Form::radio('genere', 'F', false, ['style' => 'display:inline;'])); ?>

                    <?php echo e(Form::label('genere', 'Femmina', ['style' => 'display:inline;'])); ?>

                    <?php echo e(Form::radio('genere', 'A', false, ['style' => 'display:inline;'])); ?>

                    <?php echo e(Form::label('genere', 'Altro', ['style' => 'display:inline;'])); ?>

                    <?php if($errors->first('genere')): ?>
                        <ul class="errors">
                            <?php $__currentLoopData = $errors->get('genere'); $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $message): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                                <li><?php echo e($message); ?></li>
                            <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                        </ul>
                    <?php endif; ?>

                    <?php echo e(Form::label('telefono', 'Numero di telefono', ['class' => 'label-input'])); ?>

                    <?php echo e(Form::text('telefono', '', ['class' => 'input', 'id' => 'telefono', 'rules' => 'phone', 'required' => 'required'])); ?>

                    <?php if($errors->first('telefono')): ?>
                        <ul class="errors">
                            <?php $__currentLoopData = $errors->get('telefono'); $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $message): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                                <li><?php echo e($message); ?></li>
                            <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                        </ul>
                    <?php endif; ?>

                    <?php echo e(Form::label('email', 'Email', ['class' => 'label-input'])); ?>

                    <?php echo e(Form::text('email', '', ['class' => 'input', 'id' => 'email', 'rules' => 'email', 'required' => 'required'])); ?>

                    <?php if($errors->first('email')): ?>
                        <ul class="errors">
                            <?php $__currentLoopData = $errors->get('email'); $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $message): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                                <li><?php echo e($message); ?></li>
                            <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                        </ul>
                    <?php endif; ?>
                </div>

                <div class="form-right">
                    <?php echo e(Form::label('username','Username' )); ?>

                    <?php echo e(Form::text('username', '', array('required' => 'required'))); ?>

                    <?php if($errors->first('username')): ?>
                        <ul class="errors">
                            <?php $__currentLoopData = $errors->get('username'); $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $message): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                                <li><?php echo e($message); ?></li>
                            <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                        </ul>
                    <?php endif; ?>

                    <?php echo e(Form::label('password', 'Password')); ?>

                    <?php echo e(Form::password('password', array('required' => 'required'))); ?>

                    <?php if($errors->first('password')): ?>
                        <ul class="errors">
                            <?php $__currentLoopData = $errors->get('password'); $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $message): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                                <li><?php echo e($message); ?></li>
                            <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                        </ul>
                    <?php endif; ?>
                </div>
            </div>

            <?php echo e(Form::submit('Registrazione', ['class' => 'btn'])); ?>

            <?php echo e(Form::close()); ?>


            <div class="form-alt-container">
                <p>Hai già un account?<b><a href="<?php echo e(route('login')); ?>" class="form-alt-link">
                            Effettua il Login</a></b>
                </p>
            </div>
        </div>
    </div>
<?php $__env->stopSection(); ?>

<?php echo $__env->make('layouts.skel', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\Applicazioni\XAmpp\download\htdocs\ProgettoTecnologieWeb\resources\views/auth/registrazione.blade.php ENDPATH**/ ?>